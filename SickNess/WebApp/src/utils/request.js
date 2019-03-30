/**
 * Requests a URL, returning a promise.
 *
 * @param  {string} url       The URL we want to request
 * @param  {object} [options] The options we want to pass to "fetch"
 * @return {object}           An object containing either "data" or "err"
 */
export default function request(url, options, callback) {
	options.credentials = 'include';
	fetch(url, options)
		.then(result => result.json())
		.then((data) => {
			callback(data);
		});
}
