
function temporizador(mensaje, callback) {
    setTimeout(() => {
        callback(mensaje);
    }, 3000);
}

function mostrarMensaje(mensaje) {
    console.log(mensaje);
}

console.log("Esperando 3 segundos...");
temporizador("Pasaron 3 segundos", mostrarMensaje);
