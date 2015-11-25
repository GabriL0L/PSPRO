/* EJERCICIO 1
window.onload = function () {

  document.getElementById("insultar").disabled = true;
  document.getElementById("insultar").addEventListener("click", insultar);
  document.getElementById("activar").addEventListener("click", activar);

  function insultar() {
    document.getElementsByTagName("h1")[0].innerHTML = "¡Tonto eres!";
  }

  function activar() {
    if (this.innerHTML === "Activar") {
      console.log("Activar");
      document.getElementById('insultar').removeAttribute("disabled");
      this.innerHTML = "Desactivar";
    } else {
      console.log("Desactivar");
      document.getElementById('insultar').setAttribute("disabled", "disabled");
      this.innerHTML = "Activar";
    }

  }

}*/

/*EJERCICIO 2
window.onload = function () {

  var base = 12;
  var nodo = document.getElementById("colega");

  document.getElementById("btnNegrita").addEventListener("click", negrita);
  document.getElementById("btnCursiva").addEventListener("click", cursiva);

  function negrita() {
    nodo.style.fontWeight = "bold";
    nodo.style.fontSize = base + 'px';
    base++;
  }

  function cursiva() {
    nodo.classList.toggle('negritaCursiva');
  }

}*/

window.onload = function () {

  /*EJERCICIO 3
  document.getElementById("btnColor").addEventListener("click", color);

  function color() {
    this.parentNode.style.backgroundColor = "blue";
  }*/

  /*EJERCICIO 4
  var filas = document.querySelectorAll("#tablita tr");
  var padre;

  for (var i = 0; i < filas.length; i++) {
    filas[i].addEventListener("click", cambioColor);
  }

  function cambioColor() {
    padre = this.parentNode;
    switch (this.firstChild.textContent) {
    case 'Amarillo':
      padre.lastElementChild.firstChild.style.backgroundColor = "yellow";
      break;
    case 'Azul':
      padre.lastElementChild.lastChild.backgroundColor = "blue";
      break;
    case 'Rojo':
      padre.lastElementChild.lastChild.backgroundColor = "red";
      break;
    case 'Reset':
      padre.lastElementChild.lastChild.backgroundColor = "grey";
      break;
    }
  }*/

  /*EJERCICIO 5
  document.getElementById("btnAnadir").addEventListener("click", anadir);


  function anadir() {
    var parrafo = document.createElement("p");
    var texto = document.createTextNode("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam eveniet provident repellendus rem ea blanditiis quisquam at, inventore eos, expedita harum illo, itaque velit aperiam unde quos impedit quaerat quae.");
    parrafo.appendChild(texto);
    document.body.appendChild(parrafo);
  }*/

  /*EJERCICIO 6
  document.getElementById("btnAnadir").addEventListener("click", anadir);


  function anadir() {
    var clon = document.getElementById("parrafo").cloneNode(true);
    clon.style.display = "block";
    document.body.appendChild(clon);
  }*/

}