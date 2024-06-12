//Creamos la clase y atributos con constructor
class DatosF {
    constructor(nombres,apellidos, email, telefono, usuario, password, tema, descripcion, costo, capacidad, curso) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.tema = tema;
        this.descripcion = descripcion;
        this.costo = costo;
        this.capacidad = capacidad;
        this.curso = curso;
    }
}
//Instanciamos los Objetos de las clase Padre
const datos1 = new DatosF();
datos1.nombres;
datos1.apellidos;
datos1.email;
datos1.telefono;
datos1.usuario;
datos1.password;
datos1.tema;
datos1.descripcion;
datos1.costo;
datos1.capacidad;
datos1.curso;

let validarForm = document.querySelectorAll("#FormContact");
for (let i = 0; i < validarForm.length; i++) {

    validarForm[i].addEventListener('keyup', (event) => {
        validarForm[i] = this.nextElementSibling;
        
        let nombres = document.getElementById("nombres");
        nombres = event.target.value;
        let apellidos = document.getElementById("apellidos");
        apellidos = event.target.value;
        let email = document.getElementById("email");
        email = event.target.value;
        let telefono = document.getElementById("telefono");
        telefono = event.target.value;
        let usuario = document.getElementById("usuario");
        usuario = event.target.value;
        let password = document.getElementById("password");
        password = event.target.value;
        let tema = document.getElementById("tema");
        tema = event.target.value;
        let descripcion = document.getElementById("descripcion");
        descripcion = event.target.value;
        let costo = document.getElementById("costo");
        costo = event.target.value;
        let capacidad = document.getElementById("capacidad");
        capacidad = event.target.value;
        let curso = document.getElementById("curso");
        curso = event.target.value;
        //Capturando las respuestas con el innerHTML
        let c_nombres = document.querySelector("#r_nombres");
        let c_apellidos = document.querySelector("#r_apellidos");
        let c_email = document.querySelector("#r_email");
        let c_telefono = document.querySelector("#r_telefono");
        let c_usuario = document.querySelector("#r_usuario");
        let c_password = document.querySelector("#r_password");
        let c_tema = document.querySelector("#r_tema");
        let c_descripcion = document.querySelector("#r_descripcion");
        let c_costo = document.querySelector("#r_costo");
        let c_capacidad = document.querySelector("#r_capacidad");
        let c_curso = document.querySelector("#r_curso");

        switch (event.target.id) {
            case "nombres":
                if (nombres != "") {
                    c_nombres.innerHTML = ``;
                    document.getElementById("nombres").classList.add('color_verify');
                    document.getElementById("nombres").classList.remove('color_danger');
                    document.getElementById("nombres").classList.add('border_verify');
                    document.getElementById("nombres").classList.remove('border_danger');
                }
                else {
                    c_nombres.innerHTML = `
                <p class="color_danger"> Debes escribir nombres</p><br>
                `;
                    document.getElementById("nombres").classList.remove('color_verify');
                    document.getElementById("nombres").classList.add('border_danger');
                    document.getElementById("nombres").classList.add('color_danger');
                }
                break;
            
            case "apellidos":
                if (apellidos != "") {
                    c_apellidos.innerHTML = ``;
                    document.getElementById("apellidos").classList.add('color_verify');
                    document.getElementById("apellidos").classList.remove('color_danger');
                    document.getElementById("apellidos").classList.add('border_verify');
                    document.getElementById("apellidos").classList.remove('border_danger');
                }
                else {
                    c_apellidos.innerHTML = `
                <p class="color_danger"> Debes escribir tus apellidos</p><br>
                `;
                    document.getElementById("apellidos").classList.remove('color_verify');
                    document.getElementById("apellidos").classList.add('border_danger');
                    document.getElementById("apellidos").classList.add('color_danger');
                }
                break;   
            case "email":
                if (email != "") {
                    c_email.innerHTML = ``;
                    document.getElementById("email").classList.add('color_verify');
                    document.getElementById("email").classList.remove('color_danger');
                    document.getElementById("email").classList.add('border_verify');
                    document.getElementById("email").classList.remove('border_danger');

                    if (email.indexOf('@', 0) == -1) {
                        c_email.innerHTML = `<p class="color_span">No es una dirección de email correcta</p> <br>`;
                        document.getElementById("email").classList.remove('border_verify');
                        document.getElementById("email").classList.remove('color_verify');
                    }
                    else {
                        c_email.innerHTML = `<svg preserveAspectRatio="xMidYMin" class="posit_abs right1 top3" width="24" height="24" viewBox="0 0 24 24" fill="var(--color_verify)" aria-hidden="true" style="--size: 24px; --rotate: 0deg; width: 24px; height: 24px;"><path fill-rule="evenodd" d="M20.53 5.47a.75.75 0 0 1 0 1.06l-11 11a.75.75 0 0 1-1.06 0l-5-5a.75.75 0 1 1 1.06-1.06L9 15.94 19.47 5.47a.75.75 0 0 1 1.06 0Z" clip-rule="evenodd"></path></svg>`;
                    }
                }
                else {
                    c_email.innerHTML = `<p class="color_danger">Debes de escribir un email</p> <br>`;
                    document.getElementById("email").classList.remove('color_verify');
                    document.getElementById("email").classList.add('border_danger');
                    document.getElementById("email").classList.add('color_danger');
                }
                break;

            case "telefono":
                if (telefono != "") {
                    c_telefono.innerHTML = ``;
                    document.getElementById("telefono").classList.add('c_security');
                    document.getElementById("telefono").classList.remove('c_danger');
                    document.getElementById("telefono").classList.add('border_verify');
                    document.getElementById("telefono").classList.remove('border_danger');
                }
                else {
                    c_telefono.innerHTML = `
                <p class="color_danger">Es necesario añadir un número telefónico</p> <br>
                `;
                    document.getElementById("telefono").classList.remove('c_security');
                    document.getElementById("telefono").classList.add('border_danger');
                    document.getElementById("telefono").classList.add('c_danger');
                }
                break;
            case "usuario":
                if (usuario != "") {
                    c_usuario.innerHTML = ``;
                    document.getElementById("usuario").classList.add('color_verify');
                    document.getElementById("usuario").classList.remove('color_danger');
                    document.getElementById("usuario").classList.add('border_verify');
                    document.getElementById("usuario").classList.remove('border_danger');
                }
                else {
                    c_usuario.innerHTML = `
                <p class="color_danger"> Debes escribir un usuario</p><br>
                `;
                    document.getElementById("usuario").classList.remove('color_verify');
                    document.getElementById("usuario").classList.add('border_danger');
                    document.getElementById("usuario").classList.add('color_danger');
                }
                break;

            case "password":
                if (password != "") {
                    c_password.innerHTML = `
                    <svg preserveAspectRatio = "xMidYMin" class="posit_abs right1 top3" width = "24" height = "24" viewBox = "0 0 24 24" fill = "var(--color_verify)" aria - hidden="true" style = "--size: 24px; --rotate: 0deg; width: 24px; height: 24px;" > <path fill-rule="evenodd" d="M20.53 5.47a.75.75 0 0 1 0 1.06l-11 11a.75.75 0 0 1-1.06 0l-5-5a.75.75 0 1 1 1.06-1.06L9 15.94 19.47 5.47a.75.75 0 0 1 1.06 0Z" clip-rule="evenodd"></path></svg>
                    `;
                    document.getElementById("password").classList.add('color_verify');
                    document.getElementById("password").classList.remove('color_danger');
                    document.getElementById("password").classList.add('border_verify');
                    document.getElementById("password").classList.remove('border_danger');
                }
                else {
                    c_password.innerHTML = `
                <p class="color_danger">Es necesario la contraseña</p><br>
                `;
                    document.getElementById("password").classList.remove('color_verify');
                    document.getElementById("password").classList.add('border_danger');
                    document.getElementById("password").classList.add('color_danger');
                }
                break;

            case "tema":
                if (tema != "") {
                    c_tema.innerHTML = ``;
                    document.getElementById("tema").classList.add('c_security');
                    document.getElementById("tema").classList.remove('c_danger');
                    document.getElementById("tema").classList.add('border_security');
                    document.getElementById("tema").classList.remove('border_danger');
                }
                else {
                    c_tema.innerHTML = `
                <p class="color_danger"> Debes escribir el tema</p><br>
                `;
                    document.getElementById("tema").classList.remove('c_security');
                    document.getElementById("tema").classList.add('border_danger');
                    document.getElementById("tema").classList.add('c_danger');
                }
                break;

            case "descripcion":
                if (descripcion != "") {
                    c_descripcion.innerHTML = ``;
                    document.getElementById("descripcion").classList.add('c_security');
                    document.getElementById("descripcion").classList.remove('c_danger');
                    document.getElementById("descripcion").classList.add('border_security');
                    document.getElementById("descripcion").classList.remove('border_danger');
                }
                else {
                    c_descripcion.innerHTML = `
                <h6 class="c_danger f_r"> Es necesario llenar la descripción</h6><br>
                `;
                    document.getElementById("descripcion").classList.remove('c_security');
                    document.getElementById("descripcion").classList.add('border_danger');
                    document.getElementById("descripcion").classList.add('c_danger');
                }
                break;

            case "costo":
                if (costo != "") {
                    c_costo.innerHTML = ``;
                    document.getElementById("costo").classList.add('c_security');
                    document.getElementById("costo").classList.remove('c_danger');
                    document.getElementById("costo").classList.add('border_security');
                    document.getElementById("costo").classList.remove('border_danger');
                }
                else {
                    c_costo.innerHTML = `
                <h6 class="c_danger f_r"> Es necesario añadir el costo</h6><br>
                `;
                    document.getElementById("costo").classList.remove('c_security');
                    document.getElementById("costo").classList.add('border_danger');
                    document.getElementById("costo").classList.add('c_danger');
                }
                break;

            case "capacidad":
                if (capacidad != "") {
                    c_capacidad.innerHTML = ``;
                    document.getElementById("capacidad").classList.add('c_security');
                    document.getElementById("capacidad").classList.remove('c_danger');
                    document.getElementById("capacidad").classList.add('border_security');
                    document.getElementById("capacidad").classList.remove('border_danger');
                }
                else {
                    c_capacidad.innerHTML = `
                <h6 class="c_danger f_r"> Debes añadir la capacidad de personas</h6><br>
                `;
                    document.getElementById("capacidad").classList.remove('c_security');
                    document.getElementById("capacidad").classList.add('border_danger');
                    document.getElementById("capacidad").classList.add('c_danger');
                }
                break;

            case "curso":
                if (curso != "") {
                    c_curso.innerHTML = ``;
                    document.getElementById("curso").classList.add('c_security');
                    document.getElementById("curso").classList.remove('c_danger');
                    document.getElementById("curso").classList.add('border_security');
                    document.getElementById("curso").classList.remove('border_danger');
                }
                else {
                    c_curso.innerHTML = `
                <h6 class="c_danger f_r"> Debes seleccionar un curso</h6><br>
                `;
                    document.getElementById("curso").classList.remove('c_security');
                    document.getElementById("curso").classList.add('border_danger');
                    document.getElementById("curso").classList.add('c_danger');
                }
                break;
        }

    })};