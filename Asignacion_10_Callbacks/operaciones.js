
function suma(a, b) {
    return a + b;
}

function resta(a, b) {
    return a - b;
}

function multiplicacion(a, b) {
    return a * b;
}

function division(a, b) {
    if (b === 0) {
        return "Error: no se puede dividir entre 0";
    }
    return a / b;
}

function operacionMatematica(a, b, operacion, callback) {
    const resultado = operacion(a, b);
    callback(resultado);
}

function mostrarResultado(resultado) {
    console.log(`El resultado es: ${resultado}`);
}

operacionMatematica(10, 2, suma, mostrarResultado);
operacionMatematica(10, 5, resta, mostrarResultado);
operacionMatematica(5, 2, multiplicacion, mostrarResultado);
operacionMatematica(6, 3, division, mostrarResultado);
