/**
 * выполнить асинхронный экшн.
 */
function asyncAction(url, params) {
	var func = function (jsonResponse) {

		var $messageBox = params.messageBox;

		if (typeof $messageBox == 'string') {
			$messageBox = $($messageBox);
		}

		if ($messageBox) {

			$messageBox.empty();

			if (jsonResponse.success) {
				$messageBox.append('<div class="alert alert-success">Запрос выполнен</div>');
			}

			var messages = jsonResponse.messages;
			for (var messageKey in messages) {
				if (messages.hasOwnProperty(messageKey)) {
					$messageBox.append('<div class="alert alert-info">' + messages[messageKey] + '</div>');
				}
			}
			var errors = jsonResponse.errors;
			for (var errorKey in errors) {
				if (errors.hasOwnProperty(errorKey)) {
					$messageBox.append('<div class="alert alert-error">' + errors[errorKey] + '</div>');
				}
			}

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
 * Перезагрузить элемент, содержимым ответа на запрос по урлу. предельно просто, без спецэффектов.
 * @param element - jquery объект или строковы селектор.
 * @param url
 */
function reloadElementContent(element, url) {
	var _element = element;
	if (typeof element == 'string') {
		_element = $(element);
	}
	_element.load(url);
}


/**
 * Перезагрузить контент блочного элемента с fade-эффектом.
 *
 * @param element - jquery объект или строковы селектор.
 * @param url     - URL post-запроса
 * @param params
 * @param params.postData      тело запроса
 * @param params.callback      коллбэк после выполения действия
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
		cache: false,
		success: function (msg) {
			_msg = msg;
			ajaxDeferred.resolve(msg);
		}
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