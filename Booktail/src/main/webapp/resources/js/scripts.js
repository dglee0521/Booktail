/*!
* Start Bootstrap - Shop Homepage v5.0.4 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project


// 숫자 3자리 콤마찍기

Number.prototype.formatNumber = function(){

    if(this==0) return 0;

    let regex = /(^[+-]?\d+)(\d)/;

    let nstr = (this + '');

    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');

    return nstr;

};