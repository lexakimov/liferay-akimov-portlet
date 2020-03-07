/**
 * Маски полей ввода
 */
function initInputMasks() {
	$('input.numeric-float').inputmask({
		alias: 'decimal',
		radixPoint: ","
	});

	$('input.numeric-float-positive').inputmask({
		alias: 'decimal',
		radixPoint: ",",
		allowMinus: false
	});

	$('input.numeric-integer').inputmask({
		alias: 'integer'
	});

	$('input.numeric-integer-positive').inputmask({
		alias: 'integer',
		allowMinus: false
	});

	$('input.year').inputmask("9999");

	$('input.kpp').inputmask("999999999");
	$('input.ogrn').inputmask("9999999999999");
	$('input.snils').inputmask("999-999-999 99");
	$('input.inn-legal').inputmask("9999999999");
	$('input.inn-physical').inputmask("999999999999");
	$('input.oktmo').inputmask("99999999");
	$('input.passport-series').inputmask("9999");
	$('input.passport-number').inputmask("999999");
	$('input.passport-division-code').inputmask("999-999");

	$('input.date-dd-mm-yyyy').inputmask({
		alias: 'dd.mm.yyyy',
		placeholder: "дд.мм.гггг"
	});

	AUI().use('aui-datepicker', function (A) {
		new A.DatePicker({
			trigger: 'input.date-dd-mm-yyyy',
			mask: '%d.%m.%Y',
			popover: {
				zIndex: 1500
			}
		});
	});

	$('input.date-dd-mm-yyyy-MM-HH').inputmask({
		alias: 'datetime',
		placeholder: "дд.мм.гггг чч:мм",
		mask: "1.2.y h:s",
		leapday: "29.02.",
		separator: "."
	});
}

$(function () {
	initInputMasks();
});