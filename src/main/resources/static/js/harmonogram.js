


$(document).ready(function(){

    var mieSkr = ['STY', 'LUT', 'MAR', 'KWI', 'MAJ', 'CZE', 'LIP', 'SIE', 'WRZ', 'PAZ' , 'LIS', 'GRU'];
    for(var i = 0; i< mieSkr.length;i++){
        var dt = new Date(2022, i,01);
        while(dt.getDay()!=0){
            dt.setDate(dt.getDate() + 1)
        }
        $("." + mieSkr[i]).text(dt.getDate() + " . " + mieSkr[i]);
    }
});


