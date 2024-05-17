//Modal Window
let btna = document.querySelectorAll(".btn_abrir");
let btnC = document.querySelectorAll(".btn_cerrar");
let modal_c = document.getElementById("modal");

let count_c = 0;

for (let i = 0; i < btna.length; i++) {
    btna[i].addEventListener('click', function () {
        modal_c = this.nextElementSibling;
        if (count_c == 0) {
            modal_c.classList.remove("hidden");
            count_c = 1;
        }
        else {
            modal_c.classList.add("hidden");
            count_c = 0;
        }
    });
    btnC[i].addEventListener('click', function () {
        if (count_c == 0) {
            modal_c.classList.remove("hidden");
            count_c = 1;
        }
        else {
            modal_c.classList.add("hidden");
            count_c = 0;
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    const categoryButtons = document.querySelectorAll('.category-btn');
    const items = document.querySelectorAll('.item_course');

    categoryButtons.forEach(button => {
        button.addEventListener('click', () => {
            const filter = button.getAttribute('data-filter');

            items.forEach(item => {
                if (filter === 'all') {
                    item.style.display = 'block';
                } else if (item.classList.contains(filter)) {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
            });
        });
    });
});