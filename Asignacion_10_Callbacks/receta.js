
function cortarIngredientes(ingredientes, callback) {
    setTimeout(() => {
        console.log(`Cortando: ${ingredientes}`);
        callback();
    }, 2000);
}

function cocinar(accion, callback) {
    setTimeout(() => {
        console.log(`Cocinando: ${accion}`);
        callback();
    }, 3000);
}

function servirPlato(plato) {
    setTimeout(() => {
        console.log(`Sirviendo: ${plato}`);
    }, 3000);
}


function prepararReceta(plato, callback) {
    console.log(`Comenzando a preparar ${plato}`);

    cortarIngredientes("vegetales", () => {
        cocinar("saltear", () => {
            cortarIngredientes("pollo", () => {
                cocinar("freir", () => {
                    cocinar("mezclar todo", () => {
                        servirPlato(plato);
                        callback();
                    })
                })
            })
        })
    })
}

prepararReceta("Pollo a la wok", () => { console.log("Receta completa") })