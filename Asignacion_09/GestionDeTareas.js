// =====================================
// Sistema de Gestión de Tareas
// =====================================

/*
INSTRUCCIONES GENERALES:

1. Lee cuidadosamente cada sección.
2. Completa únicamente donde se indica con TODO.
3. No borres la estructura base.
4. Agrega comentarios explicando tu lógica.
5. Prueba cada función antes de continuar.
6. NO USAR INTELIGENCIA ARTIFICIAL.
*/


// =====================================
// 1. Arreglo inicial de tareas
// =====================================

/*
Cada tarea tiene:
- nombre: string
- prioridad: number (1 = alta, 2 = media, 3 = baja)
- completada: boolean
*/

const tareas = [
  { nombre: "Ir a la playa", prioridad: 1, completada: false },
  { nombre: "Estudiar JS", prioridad: 2, completada: true },
  { nombre: "Ver películas", prioridad: 3, completada: false }
];


// =====================================
// 2. Funciones
// =====================================

/*
TODO 1:
Crear una función que recorra el arreglo de tareas
y muestre en consola:
- nombre de la tarea
- estado: "Completada" o "Pendiente"
*/
function mostrarTareas(lista) {
  // Recorremos el arreglo con forEach
  lista.forEach(tarea => {
    // Determinamos el estado según el booleano
    const estado = tarea.completada ? "Completada" : "Pendiente";
    console.log(tarea.nombre, "-", estado);
  });
}


/*
TODO 2:
Crear una función flecha que retorne
solo las tareas completadas.
Usar filter.
*/
const obtenerCompletadas = (lista) => {
  // Filtramos solo las tareas donde completada es true
  return lista.filter(tarea => tarea.completada === true);
};


/*
TODO 3:
Crear una función flecha que retorne
solo las tareas pendientes.
Usar filter.
*/
const obtenerPendientes = (lista) => {
  // Filtramos solo las tareas donde completada es false
  return lista.filter(tarea => tarea.completada === false);
};


/*
TODO 4:
Crear una función flecha que retorne
solo los nombres de las tareas.
Usar map.
*/
const obtenerNombres = (lista) => {
  // Usamos map para extraer solo el nombre de cada tarea
  return lista.map(tarea => tarea.nombre);
};


/*
TODO 5:
Crear una función que retorne
el total de tareas.
*/
function contarTareas(lista) {
  // Retornamos el tamaño del arreglo
  return lista.length;
}


// =====================================
// 3. Objeto sistema
// =====================================

/*
TODO 6:
Completar los métodos usando this.tareas

- mostrarTareas: debe llamar a la función mostrarTareas
- mostrarCompletadas: debe usar obtenerCompletadas
- mostrarPendientes: debe usar obtenerPendientes
*/

const sistema = {
  tareas: tareas,

  mostrarTareas: function() {
    // Llamamos a la función pasando this.tareas
    mostrarTareas(this.tareas);
  },

  mostrarCompletadas: function() {
    // Mostramos solo tareas completadas
    console.log(obtenerCompletadas(this.tareas));
  },

  mostrarPendientes: function() {
    // Mostramos solo tareas pendientes
    console.log(obtenerPendientes(this.tareas));
  }
};


// =====================================
// 4. Condicionales
// =====================================

/*
TODO 7:

- Si el arreglo tareas está vacío:
  mostrar "No hay tareas"

- Si todas las tareas están completadas:
  mostrar "Todas las tareas completadas"
*/

// Verificamos si no hay tareas
if (tareas.length === 0) {
  console.log("No hay tareas");
}
// Verificamos si todas están completadas
else if (tareas.every(tarea => tarea.completada === true)) {
  console.log("Todas las tareas completadas");
}


// =====================================
// 5. Switch
// =====================================

/*
TODO 8:

Usar la variable opcion para ejecutar:

1 -> mostrar todas las tareas
2 -> mostrar tareas completadas
3 -> mostrar tareas pendientes
default -> mostrar "Opción inválida"
*/

const opcion = 1;

switch (opcion) {
  case 1:
    sistema.mostrarTareas();
    break;

  case 2:
    sistema.mostrarCompletadas();
    break;

  case 3:
    sistema.mostrarPendientes();
    break;

  default:
    console.log("Opción inválida");
}


// =====================================
// 6. Pruebas
// =====================================

/*
TODO 9:

Llamar funciones para comprobar que todo funciona correctamente.
Usar console.log donde sea necesario.
*/

// Pruebas básicas
console.log("Total de tareas:", contarTareas(tareas));
console.log("Nombres:", obtenerNombres(tareas));
sistema.mostrarTareas();