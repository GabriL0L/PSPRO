window.onload = function () {

  document.getElementById("botoncito").addEventListener("click", mostrar);
  document.getElementById("cerrar").addEventListener("click", ocultar);

  function mostrar(event) {
    event.preventDefault();
    document.getElementById("alerta").classList.add("alertaVisible");
    if (document.formulario.esRepetidor.checked == true) {
      var texto = "Nombre: " + document.formulario.nombre.value +
        "\nEdad: " + document.formulario.edad.value +
        "\nEs repetidor." +
        "\nPoblacion: " + document.formulario.poblacion.options[document.formulario.poblacion.selectedIndex].value +
        "\nSexo: " + document.querySelector('.sexo:checked').value +
        "\nComentario: " + document.formulario.comentario.value;
      document.getElementById("muestraAlerta").textContent = texto;
    } else {
      var texto = "Nombre: " + document.formulario.nombre.value +
        "\nEdad: " + document.formulario.edad.value +
        "\nPoblacion: " + document.formulario.poblacion.options[document.formulario.poblacion.selectedIndex].value +
        "\nSexo: " + document.querySelector('.sexo:checked').value +
        "\nComentario: " + document.formulario.comentario.value;
      document.getElementById("muestraAlerta").textContent = texto;
    }

  }

  function ocultar() {
    document.getElementById("alerta").classList.remove("alertaVisible");
  }

}

/*if (document.formulario.esRepetidor.checked == true) {
      window.alert("Nombre: " + document.formulario.nombre.value +
        "\nEdad: " + document.formulario.edad.value +
        "\nEs repetidor." +
        "\nPoblacion: " + document.formulario.poblacion.options[document.formulario.poblacion.selectedIndex].value +
        "\nSexo: " + document.querySelector('.sexo:checked').value +
        "\nComentario: " + document.formulario.comentario.value);
    } else {
      window.alert("Nombre: " + document.formulario.nombre.value +
        "\nEdad: " + document.formulario.edad.value +
        "\nPoblacion: " + document.formulario.poblacion.options[document.formulario.poblacion.selectedIndex].value +
        "\nSexo: " + document.querySelector('.sexo:checked').value +
        "\nComentario: " + document.formulario.comentario.value);
    }*/