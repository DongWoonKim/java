
$(document).ready(() => {
    checkSession();
    loadBoardDetail();
});

let checkSession = () => {
    let hUserId = $('#hiddenUserId').val();

    if (hUserId == null || hUserId === '')
        window.location.href = "/member/login";
}

let loadBoardDetail = () => {

    let hId = $('#hiddenId').val();
    let hUserId = $('#hiddenUserId').val();

    $.ajax({
        type: 'GET',
        url: '/api/board/' + hId,
        success: (response) => {
            $('#title').text(response.title);
            $('#content').text(response.content);
            $('#userId').text(response.userId);
            $('#created').text(response.created);
            if (hUserId != response.userId) {
                $('#editBtn').prop('disabled', true);
            }
        },
        error: function (error) {
            console.error('오류 발생:', error);
            alert('상세 데이터를 불러오는데 오류가 발생했습니다.');
        }
    });
}