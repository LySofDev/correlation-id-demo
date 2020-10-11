document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('div').forEach(div => {
        div.addEventListener('click', () => {
            fetch(`http://localhost:8080/${div.id}`)
                .then(response => response.text())
                .then(message => console.log(message))
                .catch(error => console.error(error));
        });
    });
});