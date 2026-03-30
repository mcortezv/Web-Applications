/**
 * Función: prepareActivities
 * Objetivo:
 *  - Recibir un arreglo de enteros.
 *  - Eliminar valores duplicados.
 *  - Ordenar el resultado en orden ascendente.
 *  - Manejar correctamente el caso de arreglo vacío.
 *
 * Decisiones de implementación:
 *  - Uso de Set para eliminar duplicados de forma eficiente (O(n)).
 *  - Conversión de nuevo a array usando spread operator.
 *  - Ordenamiento con sort numérico (no el default lexicográfico).
 */

function prepareActivities(activities) {
    // Validación básica: si no es un arreglo o está vacío, retornar arreglo vacío
    if (!Array.isArray(activities) || activities.length === 0) {
        return [];
    }

    // 1. Eliminar duplicados usando Set
    const uniqueActivities = [...new Set(activities)];

    // 2. Ordenar numéricamente en orden ascendente
    uniqueActivities.sort((a, b) => a - b);

    // 3. Retornar el resultado
    return uniqueActivities;
}


// Pruebas
const activities1 = [3, 1, 2, 3, 4, 2, 5];
const plannedActivities1 = prepareActivities(activities1);
console.log(plannedActivities1); // [1, 2, 3, 4, 5]

const activities2 = [6, 5, 5, 5, 5];
const plannedActivities2 = prepareActivities(activities2);
console.log(plannedActivities2); // [5, 6]

const activities3 = [];
const plannedActivities3 = prepareActivities(activities3);
console.log(plannedActivities3); // []