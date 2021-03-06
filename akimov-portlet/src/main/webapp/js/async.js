/**
 * выполнить асинхронный экшн.
 *
 * @param params.data                   (необязательно) payload post запроса
 * @param params.messageBox             (необязательно) куда загрузить html с сообщениями из ответа.
 * @param params.callback(jsonResponse) (необязательно) функция обратного вызова.
 */
function asyncAction(url, params) {
	var func = function (jsonResponse) {

		var $messageBox = params.messageBox;

		if (typeof $messageBox == 'string') {
			$messageBox = $($messageBox);
		}

		if ($messageBox) {

			$messageBox.empty();
			$messageBox.show();
			$messageBox.append(buildActionResultHtml(jsonResponse));

			setTimeout(function () {
				$messageBox.fadeOut(1000, function () {
					$messageBox.empty();
				});
			}, 5000);
		}

		params.callback(jsonResponse);
	};

	$.post(url, params.data, func, 'json');
}

/**
 * Преобразовать ответ от асинхронного метода из json в html-уведомления (ошибки, предупреждения, и т.д.)
 * @param jsonResponse      ответ от асинхроного метода.
 * @returns                 html
 */
function buildActionResultHtml(jsonResponse) {
	var html = '';

	if (jsonResponse.success) {
		html = html.concat('<div class="alert alert-success">Запрос выполнен</div>');
	}

	var errors = jsonResponse.errors;
	if (errors) {
		Object.keys(errors).sort().forEach(function (key) {
			if (errors.hasOwnProperty(key)) {
				html = html.concat('<div class="alert alert-error">' + errors[key] + '</div>');
			}
		});
	}

	var messages = jsonResponse.messages;
	if (messages) {
		var suffixes = ['success', 'error', 'block', 'info'];
		var messageTypesAndKeys = Object.keys(messages).map(function (messageKey) {
			var messageKeySuffix = messageKey.substring(0, messageKey.indexOf("."));
			if (suffixes.indexOf(messageKeySuffix) === -1) {
				messageKeySuffix = 'info'
			}
			return {
				msgSuffix: messageKeySuffix, msgKey: messageKey
			};
		});

		messageTypesAndKeys.sort(function (a, b) {
			return suffixes.indexOf(a.msgSuffix) > suffixes.indexOf(b.msgSuffix)
				? 1 : suffixes.indexOf(a.msgSuffix) < suffixes.indexOf(b.msgSuffix)
					? -1 : 0;
		});

		messageTypesAndKeys.forEach(function (entry) {
			if (messages.hasOwnProperty(entry.msgKey)) {
				html = html.concat('<div class="alert alert-' + entry.msgSuffix + '">' + messages[entry.msgKey] + '</div>');
			}
		});
	}
	return html;
}

/**
 * Асинхронная перезагрузка элемента страницы содержимым ответа на запрос по урлу.
 * Предельно просто, без каких-либо спецэффектов.
 * @param element   jquery объект или строковый селектор.
 * @param url       предполагается, что это renderURL с windowState="exclusive", хотя по идее можно указать какой угодно.
 */
function reloadElementContent(element, url) {
	var _element = element;
	if (typeof element == 'string') {
		_element = $(element);
	}
	_element.load(url);
}


/**
 * Асинхронная перезагрузка элемента страницы с fade-эффектом. Рекомендуется использоваться для запросов, которые
 * обрабатываются не сразу.
 *
 * @param element           jquery объект или строковы селектор.
 * @param url               URL post-запроса
 * @param params
 * @param params.postData   тело запроса
 * @param params.callback   коллбэк после выполения действия
 */
function reloadElementContentAdvanced(element, url, params) {
	var _element = element;
	if (typeof element == 'string') {
		_element = $(element);
	}

	var _data = (typeof params == 'undefined') ? undefined : params.postData;
	var _callback = (typeof params == 'undefined') ? undefined : params.callback;

	var fadeDeferred = $.Deferred();
	var ajaxDeferred = $.Deferred();

	_element.fadeTo(400, 0.0, fadeDeferred.resolve);

	var _msg;

	$.ajax({
		type: 'POST',
		url: url,
		data: _data,
		cache: false
	}).done(function (msg) {
		_msg = msg;
		ajaxDeferred.resolve();
	});

	$.when(fadeDeferred, ajaxDeferred).done(function () {
		_element.html(_msg);
		_element.fadeTo(400, 1, function () {
			if (_callback) {
				_callback();
			}
		});
	});
}