<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var = "root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${root}/Inner-Website/lib/css/inner-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <title>Movies</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sub_header.jsp"></jsp:include>
	<jsp:include page="banner.jsp"></jsp:include>
	<jsp:include page="content.jsp"></jsp:include>
  <script>
  "use strict"

//event click Input

const search = document.querySelector('.fa-search');
const playMovieBanner = document.querySelector('.banner-btn-play')
const infoMovieBanner = document.querySelector('.banner-btn-info')
const body = document.querySelector('body');

//scroll vertically
loadTrailer();


window.addEventListener('scroll', function() {
   const header = document.querySelector("header");
   header.classList.toggle('scrollTop', window.scrollY > 0);
})



//show menu of genres
const subHeader = document.querySelector('.sub-header');
const genres = document.querySelector('.sub-header-genres');
const menuGenres = genres.querySelector('.sub-header-menu');

genres.addEventListener('click', (e) => {
   genres.classList.toggle('changeColor');
   menuGenres.classList.toggle('show');
})
window.addEventListener("click", function(e) {
   if (!e.target.matches('.sub-header-genres')) {
       genres.classList.remove('changeColor');
       menuGenres.classList.remove('show');
   }
});


function loadTrailer() {
   setTimeout(() => {
       document.querySelector('header').classList.add('z-index');
       document.querySelector('.banner-content-text').classList.add('hide')
       document.querySelector('.banner-content-img img').classList.add('zoom-out')
       document.querySelector('.banner .banner-img img').classList.add('hide')
       document.querySelector('.trailer-film').querySelector('iframe').classList.add('show')
   }, 4000);
}

//loading trailer in Preview (Info)
function loadTrailerInfo() {
   setTimeout(() => {
       document.querySelector('.preview-detail-banner').querySelector('img').classList.add('hide');
       document.querySelector('.preview-detail-banner').querySelector('iframe').classList.add('show')

   }, 4000);
}

//stopping trailer in Preview (Info)
function stopTrailerInfo() {
   document.querySelector('.preview-detail-banner').querySelector('img').classList.remove('hide');
   document.querySelector('.preview-detail-banner').querySelector('iframe').classList.remove('show')
}
//stop iframe youtube trailer banner
function OffTrailer() {
   document.querySelector('header').classList.remove('z-index');
   document.querySelector('.banner-content-text').classList.remove('hide');
   document.querySelector('.banner-content-img img').classList.remove('zoom-out');
   document.querySelector('.trailer-film').querySelector('iframe').classList.remove('show');
   document.querySelector('.banner .banner-img img').classList.remove('hide');
}

//------------------- animation search start
search.addEventListener('click', () => {
   search.classList.toggle('show')
   if (search.classList.contains('show')) {
       document.querySelector('.search-input').classList.add('show');
   } else {
       document.querySelector('.search-input').classList.remove('show');
   }
})

//------------------- animation search end

//------------------- play movie start
const playFilm = document.querySelector('.play-film');

//back to browse


//------------------- play movie end-------


//--------------show more info start
const btnMoreInfo = document.querySelector(".banner-btn-info"),
   preview = document.querySelector(".preview"),
   trailerInfo = document.querySelector('.preview-detail-trailer'),
   linkIframe = trailerInfo.querySelector('.preview-detail-banner iframe');
btnMoreInfo.addEventListener('click', () => {
   //  stop trailer
   OffTrailer();
   loadTrailerInfo();

   preview.classList.add('open');
   document.body.classList.add('ignore-overflow-y');
})


//----- close Preview
preview.addEventListener('click', (e) => {
   if (e.target.classList.contains('preview')) {
       preview.classList.remove('open');
       body.classList.remove('ignore-overflow-y');
       // stop trailer banner
       loadTrailer();
       // stop trailer info
       stopTrailerInfo();
   }
})


//---------------------Slider start----------------------

//take all categories into an array and then set up slide 
const slides = document.querySelectorAll('.popular-slider')

//use forEach to set every slide
slides.forEach((slide, index) => {
   // take width for each slide
   const sliderPopular = slide.querySelector('.popular-slider-card'),
       slideWidth = sliderPopular.offsetWidth,

       // take all card-item to an array
       slideItems = slide.querySelectorAll('.popular-slider-card-item'),

       // use to count item in a slide and take it's width
       slideItem = slide.querySelector('.popular-slider-card-item'),
       // button prev
       prevBtn = slide.querySelector('.popular-slider-nav .prev-btn'), // button next
       nextBtn = slide.querySelector('.popular-slider-nav .next-btn'),

       trailerInfo = document.querySelector('.preview-detail-trailer'),
       linkIframe = trailerInfo.querySelector('.preview-detail-banner iframe');

   //  Count number of slide for every click.
   let countSlide = Math.ceil((slideItems.length * slideItem.offsetWidth) / (5 * slideItem.offsetWidth)),
       // set index = 0;
       slideIndex = 0;
   // click for next button
   sliderPopular.style.width = slideWidth * countSlide + 'px';

   // if slide has only 5 items. Don't have next button
   if (countSlide <= 1) {
       nextBtn.classList.add("hide");
   }
   // Number of clicking is countSlide
   nextBtn.addEventListener('click', () => {
           // if slideIndex == countSlide then reset slideIndex = 0
           if (slideIndex === countSlide - 1) {
               slideIndex = 0;
           } else {
               slideIndex++;
           }
           // if slideIndex = 0 then prev button will hide
           if (slideIndex > 0) {
               prevBtn.classList.add('active')
           } else {
               prevBtn.classList.remove('active')
           }
           slider();
       })
       // click for pre button
   prevBtn.addEventListener('click', () => {
           if (slideIndex === 0) {
               slideIndex = countSlide - 1;
           } else {
               slideIndex--;
           }
           slider();
       })
       // when it has event "click" Margin left is minus to next slideIndex
   function slider() {
       sliderPopular.style.marginLeft = -(slideWidth * slideIndex) + 'px';
   }

   //  show Info and Play video 

   let itemIndex;
   sliderPopular.addEventListener('mouseover', (e) => {
       // if addEvent exist "item hover"
       if (e.target.closest('.popular-slider-card-item--hover')) {

           // declare a parameter assign item Hover's nodeParent from E.target (The item is clicked)
           const slideCardItem = e.target.closest('.popular-slider-card-item--hover').parentElement;
           // take all Item to array.
           itemIndex = Array.from(slideCardItem.parentElement.children).indexOf(slideCardItem);
           // take info of film's id [itemIndex].
           const detail = slideItems[itemIndex].querySelector('.popular-slider-details').innerHTML;
           //  if CardItem[itemIndex] contains item-info class (More info)
           if (slideItems[itemIndex].querySelector('.item-info')) {
               slideItems[itemIndex].querySelector('.item-info').addEventListener('click', (e) => {
                   // show preview
                   // hide trailer
                   OffTrailer();
                   loadTrailerInfo();
                   // open preview
                   preview.classList.add('open');
                   preview.querySelector('.preview-detail').innerHTML = detail;
                   document.body.classList.add('ignore-overflow-y');
               })
           }
           //  if CardItem[itemIndex] contains fa-play class (Play Movie)
           if (slideItems[itemIndex].querySelector('.fa-play')) {
               slideItems[itemIndex].querySelector('.fa-play').addEventListener('click', (e) => {

               })
           }
       }
   })
})



//----------------slide end--------------------
  </script>
</body>
</html>