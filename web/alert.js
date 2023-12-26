/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    

    var datum = new Date();
    var greetings;
    var hrs = datum.getHours();

    if (hrs>=18)
    {
        greetings = "Good evening";
    }
    else if (hrs>=12)
    {
        greetings = "Good day";
    }
    else if (hrs>=0)
    {
        greetings ="Good evening";
    }
    else
    {
        greetings="welcome";
    }
    
    
    document.write(greetings);
    var el = document.getElementById('sub');
    el.textContent("Wahala");


