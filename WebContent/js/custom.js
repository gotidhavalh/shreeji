// JavaScript Document
(function($) {
  	
	$(document).ready(function() {		
		shreeji.init();		
	});
	

	var shreeji = {
        planetxTimeout: null,
		isSidebarAjaxClick: false,
		init: function() {	
            this.header();	
            this.sliderbar();	
            this.datpicker();
            this.filezoom();
//            this.selectbox();
		},
		

  	    header:function(){
            $('#sliderbarmenu').click(function(){
                $('.slidbar').toggleClass('active');
            });
        },

      sliderbar:function(){
        $('.slidbar ul li a').click(function(){
            $(this).parent().siblings().find('.menu-dropdwon').slideUp();
            $(this).siblings('.menu-dropdwon').slideToggle();
            $(this).find('.crt').toggleClass('active');
            $(this).parent().siblings().find('.crt').removeClass('active');
        });
    },
    datpicker:function(){
        $(function () {
            $('#datetimepicker1 , #datetimepicker2 , #datetimepicker3 , #datetimepicker4 , #datetimepicker5').datepicker({
                format: "dd/mm/yyyy",
                language: "es",
                autoclose: true,
                todayHighlight: true
            });
        });
    },
    filezoom:function(){
        $('.avtar-detail').click(function(){
            $(this).toggleClass('active');
            $('body').css('overflow', 'hidden');  
        });
    },
//    selectbox:function(){
//        $('selectpicker').selectpicker();
//    },
	}
})(jQuery);