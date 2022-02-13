$(function () {

    // views
    let dayDiv = $("#dayDiv");
    let monthDiv = $("#monthDiv");
    let yearDiv = $("#yearDiv");
    let generateBtn = $("#dateGeneratorBtn");
    let importanceIFrame = $("#importanceIframe");

    let timeOutId;

    const monthNames = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    setRandomDate()

    generateBtn.click(function () {

        generateBtn.animate({
            opacity: '0.5'
        }, "fast", "swing", function () {

            generateBtn.animate({
                opacity: '1'
            }, "fast");
        });

        setRandomDate()
    });

    function setRandomDate() {

        try {

            clearTimeout(timeOutId)

        } catch (e) {

        }

        let rDate = randomDate(new Date(1900, 0, 1), new Date());

        let rDay = rDate.getUTCDate();
        let rMonth = monthNames[rDate.getMonth()];
        let rYear = rDate.getUTCFullYear();

        if (rDay < 10) {

            dayDiv.text("0" + rDay);
        } else {

            dayDiv.text(rDay)
            monthDiv.text(rMonth);
            yearDiv.text(rYear);
        }

        timeOutId = setTimeout(function () {

            importanceIFrame.attr({
                "src": "https://en.wikipedia.org/wiki/" + rMonth + "_" + rDay,
                "title": "Importance of " + rMonth + " " + rDay
            });

        }, 500);

    }

    function randomDate(start, end) {
        return new Date(start.getTime() + Math.random() * (end.getTime() - start.getTime()));
    }
});