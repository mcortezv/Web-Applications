
function crearTorrePoder(altura, caracter){
    
    if (altura < 1 || altura > 100){
        return "La Altura debe ser entre 1 y 100";
    }

    let ancho = altura + (altura - 1);
    let caracterPorAltura = 1;
    let centro = Math.floor(ancho / 2);
    let linea = "";
    
    for (let i = 0; i < altura; i++) {
        for (let j = 0; j < ancho; j++){
            if (j < centro || j >= centro + caracterPorAltura){
                linea += "-";
            } else {
                linea += caracter;
            }
        }
        caracterPorAltura += 2;
        centro -= 1;
        linea += "\n";
    }
    
    for (let i = 0; i < 2; i++){
        for (let j = 0; j < ancho; j++) {
            if (j != Math.floor(ancho / 2)) {
                linea += "-";
            } else {
                linea += "#";
            }
        }
        linea += "\n";
    }
    return linea;

}

const torre = crearTorrePoder(15, "*");

console.log(torre);