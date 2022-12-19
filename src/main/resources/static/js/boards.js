$(document).ready(function() {

    $("#btn-board-save").on("click", function() {
        var board = {
            title : $("#title").val(),
            userId : $("#userId").val(),
            boardType : $("#boardType").val(),
            content : $("#content").val()
        };

//        alert(JSON.stringify(board));

        $.ajax({
            type : "POST",
            url : "/api/boards",
            data : JSON.stringify(board),
            contentType : "application/json; charset=UTF-8",
            success : function() {
//                alert("Created");
                window.location.href = "/";
            },
            error : function(xhr, testStatus, error) {
                alert("code:" + xhr.status + "\n"
                    + "message: " + xhr.responseText + "\n"
                    + "error" + error);

            }
        });
    }); // #btn-board-save

    $("#btn-board-update").on("click", function() {
        var board = {
            id : $("#id").val(),
            title : $("#title").val(),
            userId : $("#userId").val(),
            boardType : $("#boardType").val(),
            content : $("#content").val()
        };

//        alert(JSON.stringify(board));

        $.ajax({
            type : "PUT",
            url : "/api/boards",
            data : JSON.stringify(board),
            contentType : "application/json; charset=UTF-8",
            success : function() {
//                alert("Updated");
                window.location.href = "/";
            },
            error : function(xhr, testStatus, error) {
                alert("code:" + xhr.status + "\n"
                    + "message: " + xhr.responseText + "\n"
                    + "error" + error);

            }
        });
    }); // #btn-board-update

    $("#btn-board-delete").on("click", function() {
        var board = {
            id : $("#delete-id").val()
        };

        $.ajax({
            type : "DELETE",
            url : "/api/boards",
            data : JSON.stringify(board),
            contentType : "application/json; charset=UTF-8",
            success : function() {
//                alert("Deleted");
                window.location.href = "/";
            },
            error : function(xhr, status, error) {
                alert("code:" + xhr.status + "\n"
                    + "message:" + xhr.responseText + "\n"
                    + "error:" + error);
            }
        });
    }); // btn-board-delete

});
