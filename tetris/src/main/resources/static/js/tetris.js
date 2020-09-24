jQuery(function() {
   var mouseHold = false;
   var currentBlock = null;

   $('.block').children('input').prop("checked", false);

   $("#changeGrid").on("click", function (e) {
      $("#grid").empty();

      var size = $("#numberGrid").val();
      var id = 0;
      for (let i = 0; i < size; i++) {
         jQuery('<div/>', {
            class: 'row',
         }).appendTo('#grid');
      }

      $("#grid").children(".row").each(function (element) {
         for (let i = 0; i < size; i++) {
            id = id + 1;
            jQuery('<div/>', {
               id: id,
               class: 'block',
            }).appendTo(this);
         }
      });
      
   });

   $("#grid").on("mousedown", function (e) {
      mouseHold = true;
      currentBlock = null;

      var parentOffset = $('#grid').offset(); 
      var relX = e.pageX - parentOffset.left;
      var relY = e.pageY - parentOffset.top;
      var x = Math.trunc(relX/($(this).width()/$(this).children(".row").length));
      var y = Math.trunc(relY/($(this).height()/$(this).children(".row").length));


      var selectedBlock = $('#grid').children(".row:eq("+y+")").children(".block:eq("+x+")");
      if (currentBlock == null || selectedBlock.attr('id') != currentBlock.attr('id')){
         currentBlock = selectedBlock;
         $(selectedBlock).toggleClass("selected");
         $(selectedBlock).children("input").prop("checked", !$(selectedBlock).children("input").prop("checked"));
      }

   });
   $("#grid").on("mouseup", function (e) { 
      mouseHold = false;
      currentBlock = null;
   });
   $("#grid").on("mouseleave", function (e) {
      mouseHold = false;
   });

   $("#grid").on("mousemove", function (e) {
      if(mouseHold) {
         var parentOffset = $(this).offset(); 
         //or $(this).offset(); if you really just want the current element's offset
         var relX = e.pageX - parentOffset.left;
         var relY = e.pageY - parentOffset.top;
         var x = Math.trunc(relX/($(this).width()/$(this).children(".row").length));
         var y = Math.trunc(relY/($(this).height()/$(this).children(".row").length));

         var selectedBlock = $('#grid').children(".row:eq("+y+")").children(".block:eq("+x+")");
         
         if (currentBlock == null || selectedBlock.attr('id') != currentBlock.attr('id')){
            currentBlock = selectedBlock;
            currentBlock.toggleClass("selected");
            $(currentBlock).children("input").prop("checked", !$(selectedBlock).children("input").prop("checked"));
         }

      }
   });
});