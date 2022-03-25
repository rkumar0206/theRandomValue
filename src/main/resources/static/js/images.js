$(function () {

    let imageWidthInput = $("#image_width");
    let imageHeightInput = $("#image_height");
    let grayscaleCb = $("#grayscaleCB");
    let blurCB = $("#blurCB");
    let blurLevelInput = $("#blur_level");
    let imageRefreshBtn = $("#imageRefreshBtn");
    let imageIframe = $("#imageIFrame");
    let loadingObject = $(".loadingObject");

    let url = "https://picsum.photos/500/600?random=1";
    let timeOutId;

    setRandomImage();

    imageRefreshBtn.click(function () {

        imageRefreshBtn.animate({
            opacity: '0.5'
        }, "fast", "swing", function () {

            imageRefreshBtn.animate({
                opacity: '1'
            }, "fast");
        });

        setRandomImage();
    });


    function setRandomImage() {

        try {

            clearTimeout(timeOutId);

        } catch (e) {

        }

        loadingObject.show();
        imageIframe.hide();

        makeUrlString();

        initIFrame();

    }

    function initIFrame() {

        timeOutId = setTimeout(function () {

            imageIframe.attr({
                "src": url,
                "title": "Image " + imageWidthInput.val() + "x" + imageHeightInput.val()
            });

            imageIframe.on("load", function () {

                $(".loadingObject").hide();
                imageIframe.show();

            });

        }, 500);

    }

    function makeUrlString() {

        let width = imageWidthInput.val();
        let height = imageHeightInput.val();

        let isGrayscale = grayscaleCb.is(":checked");
        let isBlur = blurCB.is(":checked");
        let blurLevel = blurLevelInput.val();

        url = "https://picsum.photos/" + width + "/" + height + "?random=1";

        if (isGrayscale) {

            url += "&grayscale";
        }

        if (isBlur) {

            url += "&blur=" + blurLevel;
        }
    }


});