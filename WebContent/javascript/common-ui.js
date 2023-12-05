$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}	

	var accordion = new Accordion($('#accordion'), false);

	//달력
	var datePickerOption = {
		showOn: "both", 
		buttonImage: "/images/ico_calendar.png", 
		buttonImageOnly: true,
		dayNames: [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ],
		dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
		dayNamesShort: [ "일", "월", "화", "수", "목", "금", "토" ],
		monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
		monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
		closeText: '닫기',
		weekHeader: '주',
		dateFormat: 'yy-mm-dd',
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '년'
	};

	try{
	    $(".date_box input").datepicker(datePickerOption);	
	}catch(e){}


	//modal popup
	$('[open-modal]').on('click', function(){
		var id = $(this).attr('open-modal');
		$('.modal#'+id).addClass('active');
	});

	$('[close-modal]').on('click', function(){
		$(this).parents('.modal').removeClass('active');
	});

	$('.modal').on('click', function(e) {
		if(e.target !== this){return};
		$(this).removeClass('active');
	});


});



