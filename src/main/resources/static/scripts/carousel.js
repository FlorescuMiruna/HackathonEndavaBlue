

$ (document).ready(function() {
  var media_querry = window.matchMedia("(max-width: 1500px)");
  var media_phone = window.matchMedia("(max-width: 1000px)");
  var popup_circle = document.getElementById("circle-new");
  var circle_text = document.getElementById("textbox"); 
  var btn_new = document.getElementById("btn-new") 
  var circle_container = document.getElementById("hoverpopup");
  var hover_alert = document.getElementById("hover-alert");
  var btn_sort = document.getElementById("sort-btn");
  hover_alert.style.opacity = "1";
 
  
  new ResizeObserver(() => { 
    console.log(popup_circle.offsetHeight);
    if(popup_circle.offsetHeight < 300)
      {
        circle_text.style.display = "none";
      }  
      else{
        circle_text.style.display = "block";
      }
  }).observe(popup_circle);


  if (media_phone.matches)
    {
      popup_circle.addEventListener("mouseenter", () => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "70%";
        hover_alert.style.display = "none";
      })
      btn_new.addEventListener("mouseover",() => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "70%";
      });  
      circle_container.addEventListener("mouseleave", () => {
        circle_text.style.opacity = "0";
        btn_new.style.display = "none";
        popup_circle.style.height = "10%";
      })
    }
    else if (media_querry.matches)
    { 
     
      popup_circle.addEventListener("mouseenter", () => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
        hover_alert.style.display = "none";
      })
      btn_new.addEventListener("mouseover",() => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
      });  
      circle_container.addEventListener("mouseleave", () => {
        circle_text.style.opacity = "0";
        btn_new.style.display = "none";
        popup_circle.style.height = "20%";
      })
  }


  $( window ).resize(function() {
    var my_html = document.getElementById("entire-html");
    const scrollbarVisible = (element) => {
      return my_html.scrollHeight > my_html.clientHeight;
    }
  
    if(!scrollbarVisible(my_html))
    {
      document.getElementById("navbar").style.top = "0";
    }

    if (media_phone.matches)
    {
      popup_circle.addEventListener("mouseenter", () => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
        hover_alert.style.display = "none";
      })
      btn_new.addEventListener("mouseover",() => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
      });  
      circle_container.addEventListener("mouseleave", () => {
        circle_text.style.opacity = "0";
        btn_new.style.display = "none";
        popup_circle.style.height = "10%";
      })
    }
    else if (media_querry.matches)
    { 
      popup_circle.addEventListener("mouseenter", () => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
        hover_alert.style.display = "none";
      })
      btn_new.addEventListener("mouseover",() => {
        circle_text.style.opacity = "1";
        btn_new.style.display = "block";
        popup_circle.style.height = "80%";
      });  
      circle_container.addEventListener("mouseleave", () => {
        circle_text.style.opacity = "0";
        btn_new.style.display = "none";
        popup_circle.style.height = "20%";
      })
  }
  });
  
});