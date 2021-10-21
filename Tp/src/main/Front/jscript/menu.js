/* When the user clicks on the button,
toggle between hiding and showing the dropdown content 
function myFunction(x) {
  x.classList.toggle("change"); 
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
*/

function openSidebar() {
  const sidebar = document.getElementById("side-bar")
  sidebar.classList.add("open")
  // listener para desactivar el scroll cuando se abre el sidebar
  window.addEventListener('scroll', noScroll);
}

function closeSidebar()  {
  document.getElementById("side-bar").classList.remove("open")
}

function noScroll() {
  window.scrollTo(0, 0);
} /*traba la barrita para bajar*/


window.onclick = function(event) {
  // Me aseguro que cuando se toque el sidebar o boton (icono en realidad) no se aplique la logica
  if (!event.target.matches(".side-bar") && !event.target.matches(".fa-bars") ) {
    const sidebar = document.getElementById("side-bar")

    // Si el sidebar esta abierto, lo cierra
    if (sidebar.classList.contains("open")) {
      sidebar.classList.remove("open")
      // el listener se remueve cuando se cierra el sidebar
      window.removeEventListener('scroll', noScroll);
    }
  }
}