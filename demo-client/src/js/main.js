import 'whatwg-fetch'
import fetchIntercept from 'fetch-intercept';
import { v4 as correlationId } from 'uuid';

const API_URL = 'http://localhost:8080';

document.addEventListener('DOMContentLoaded', function () {

    fetchIntercept.register({
        request: (url, config) => {
            if (url.includes(API_URL)) {
                return [
                    `${url}${url.includes('?') ? '&' : '?'}cid=${correlationId()}`,
                    config
                ];
            }
            return [url, config];
        }
    });

    document.querySelectorAll('div').forEach(div => {
        div.addEventListener('click', () => {
            fetch(`${API_URL}/${div.id}`)
                .then(response => response.text())
                .then(message => console.log(message))
                .catch(error => console.error(error));
        });
    });
});