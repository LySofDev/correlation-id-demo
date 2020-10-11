document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('div').forEach(div => {
        div.addEventListener('click', () => {
            fetch(`http://localhost:8080/${div.id}`)
                .then((response) => response.json())
                .then((responseBody) => console.log(responseBody))
                .catch((error) => console.error(error));
        });
    });
});