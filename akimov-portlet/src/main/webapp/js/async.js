/**
 * выполнить асинхронный экшн.
 * TODO обработать возможные ошибки
 */
function asyncAction(url, params) {
	$.post(url, params.data, params.callback, 'json');
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
 * Асинхронно перезагрузить контент блочного элемента.
 *
 * @param element - jquery объект или строковы селектор.
 * @param url     - URL post-запроса
 * postData      тело запроса
 * callback      коллбэк после выполения действия
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

	$.ajax({
		type: 'POST',
		url: url,
		data: _data,
		cache: false,
		success: function (msg) {
			ajaxDeferred.resolve(msg);
		}
	});

	$.when(fadeDeferred, ajaxDeferred).done(function (msg) {
		_element.html(msg);
		_element.fadeTo(400, 1, function () {
			if (_callback) {
				_callback();
			}
		});
	});
}