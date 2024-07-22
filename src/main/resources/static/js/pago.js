// Scroll suave al hacer clic en el botón Inscribirse
let btnInscribirse = document.querySelector('.btn_abrir');
let btnCerrar = document.querySelector('.btn_cerrar');
let sectionRight = document.getElementById('section-right');

btnInscribirse.addEventListener('click', function(event) {
    event.preventDefault();

    // Mostrar la sección derecha con una animación de fade-in
    sectionRight.style.opacity = '0';
    sectionRight.style.display = 'block';
    setTimeout(function() {
        sectionRight.style.opacity = '1';
    }, 200); // Ajusta el valor según el tiempo de transición que desees

    // Retraso antes de hacer scrollIntoView
    setTimeout(function() {
        sectionRight.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }, 800); // Ajusta el valor en milisegundos según sea necesario
});

// Cerrar la sección derecha al hacer clic en el botón de cerrar
btnCerrar.addEventListener('click', function(event) {
    event.preventDefault();
    sectionRight.style.opacity = '0';
    setTimeout(function() {
        sectionRight.style.display = 'none';
    }, 200); // Ajusta el valor según el tiempo de transición que desees
});