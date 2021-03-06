"use strict"

// event click Input

const search = document.querySelector('.fa-search');
const playMovieBanner = document.querySelector('.banner-btn-play')
const infoMovieBanner = document.querySelector('.banner-btn-info')
const body = document.querySelector('body');



window.addEventListener('scroll', function() {
    const header = document.querySelector("header");
    header.classList.toggle('scrollTop', window.scrollY > 0);
})


// loading trailer in Preview (Info)
function loadTrailerInfo() {
    setTimeout(() => {
        document.querySelector('.preview-detail-banner').querySelector('img').classList.add('hide');
        document.querySelector('.preview-detail-banner').querySelector('iframe').classList.add('show')

    }, 4000);
}

// stopping trailer in Preview (Info)
function stopTrailerInfo() {
    document.querySelector('.preview-detail-banner').querySelector('img').classList.remove('hide');
    document.querySelector('.preview-detail-banner').querySelector('iframe').classList.remove('show')
}

// ------------------- animation search start
search.addEventListener('click', () => {
    search.classList.toggle('show')
    if (search.classList.contains('show')) {
        document.querySelector('.search-input').classList.add('show');
    } else {
        document.querySelector('.search-input').classList.remove('show');
    }
})

// ------------------- animation search end

//------------------- play movie end-------


// --------------show more info start
const preview = document.querySelector(".preview"),
    trailerInfo = document.querySelector('.preview-detail-trailer'),
    linkIframe = trailerInfo.querySelector('.preview-detail-banner iframe');

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


// ---------------------Slider start----------------------

// take all categories into an array and then set up slide 
const slides = document.querySelectorAll('.popular-slider')

// use forEach to set every slide
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

                    loadTrailerInfo();
                    // open preview
                    preview.classList.add('open');
                    preview.querySelector('.preview-detail').innerHTML = detail;
                    document.body.classList.add('ignore-overflow-y');
                })
            }
            //  if CardItem[itemIndex] contains fa-play class (Play Movie)
        }
    })
})



//----------------slide end--------------------