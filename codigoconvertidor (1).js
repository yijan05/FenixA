function ejecutar(){
    let arreglo ="";
    let rta="";
    arreglo = document.getElementById("letra").value;
    let variable = 0;
    variable = arreglo.charCodeAt(0);
    for (let i=7;i>=0;i--){
        if (variable>=2**i){
            rta=rta + "1";
            variable = variable - 2**i;
        }else{
            variable=variable +"0";

        }

    }
    document.getElementById("texto1").innerHTML = "Salida es " + rta;

}
function ejecutar2(){
    let arreglo2 ="";
    arreglo = document.getElementById("numero").value;
    document.getElementById("texto2").innerHTML = "Salia es " + arreglo2;

}
