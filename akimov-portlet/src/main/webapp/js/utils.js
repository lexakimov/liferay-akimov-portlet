function fileSizeHumanReadable(bytes) {
	let thresh = 1024;
	if (Math.abs(bytes) < thresh) {
		return bytes + ' байт';
	}
	let units = [' Кбайт', ' Мбайт', ' Гбайт'];
	let u = -1;
	do {
		bytes /= thresh;
		++u;
	} while (Math.abs(bytes) >= thresh && u < units.length - 1);

	return bytes.toFixed(2) + units[u];
}