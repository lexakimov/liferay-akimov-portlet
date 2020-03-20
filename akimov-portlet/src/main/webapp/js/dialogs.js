function openSimpleMessageWindow(props) {

	const _ATTRS = {
		cssClass: 'simple-modal-message',
		headerLabel: 'Заголовок окна',
		bodyContent: '',
		centered: true,
		resizable: false,
		zIndex: 1000,
		closeLabel: 'Закрыть',
		closeCallback: undefined
	};

	$.extend(_ATTRS, props);

	AUI().use('aui-modal', function (A) {
		const modal = new A.Modal({
			modal: true,
			cssClass: _ATTRS.cssClass,
			headerContent: '<h4>' + _ATTRS.headerLabel + '</h4>',
			bodyContent: _ATTRS.bodyContent,
			centered: _ATTRS.centered,
			resizable: _ATTRS.resizable,
			destroyOnHide: true,
			destroyOnClose: true,
			zIndex: _ATTRS.zIndex,
			on: {
				destroy: function (event) {
					if (typeof _ATTRS.closeCallback === "function") {
						_ATTRS.closeCallback(event);
					}
				}
			},
			toolbars: {
				footer: [
					{
						label: _ATTRS.closeLabel,
						primary: true,
						on: {
							click: function () {
								modal.destroy();
							}
						}
					}
				]
			}
		});
		modal.render();
	});

}