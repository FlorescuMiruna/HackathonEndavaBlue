$(document).ready(function(){

    $('#nav-icon1,#nav-icon2,#nav-icon3,#nav-icon4').click(function(){
        $(this).toggleClass('open');
    });

    var navbar = document.getElementById("navbar");
    var navitems = document.getElementsByClassName("nav-item");
    var hamburger = document.getElementById("hamburger");
    var logo = document.getElementById("logo");

    if(document.documentElement.scrollTop==0)
    {
        hamburger.style.filter = "invert(0%) sepia(100%) \
    saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
        logo.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

        navbar.style.setProperty("background-color","transparent","important");
        document.body.style.setProperty("--top-border-dist","0px");
    }
    window.onscroll = function(e) {
        var scrollY = window.pageYOffset || document.documentElement.scrollTop;
        if(document.documentElement.scrollTop == 0)
        {
            hamburger.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
            logo.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

            document.body.style.setProperty("--top-border-dist","0px");
            navbar.style.setProperty("background-color","transparent","important");

            for ( var i = 0; i < navitems.length ; i ++ )
                navitems[i].style.color = "white";
            document.getElementById("favourites").style.filter="invert(0%) sepia(100%) \
      saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
            document.getElementById("search").style.filter="invert(100%) sepia(0%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
        }
        else{
            navbar.style.setProperty("background-color","white","important");
            hamburger.style.filter = "invert(60%) sepia(9%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            logo.style.filter = "invert(60%) sepia(9%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            for ( var i = 0; i < navitems.length ; i ++ )
                navitems[i].style.color = "black";
            document.getElementById("favourites").style.filter="invert(100%) sepia(0%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            document.getElementById("search").style.filter="invert(0%) sepia(100%) \
      saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

        }

        if(scrollY <= this.lastScroll)
        {
            navbar.style.top = '0';
            if(document.documentElement.scrollTop != 0)
                document.body.style.setProperty("--top-border-dist","64px");
        }
        else{
            navbar.style.top = '-65px';
            document.body.style.setProperty("--top-border-dist","0px");
        }

        this.lastScroll = scrollY ;

    }
});