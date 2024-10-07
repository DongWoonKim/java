
$(document).ready(() => {
    checkSession();
    saved();
});

let saved = () => {
    $('#submitBtn').on('click', (event) => {
        event.preventDefault();

        let formData = new FormData($('#writeForm')[0]);

        $.ajax({
            type: 'POST',
            url: '/api/board', // 서버의 엔드포인트 URL
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                // 성공 시 실행될 콜백 함수
                alert('게시글이 성공적으로 등록되었습니다!')
                // 성공 후 다른 페이지로 이동하거나 처리할 코드 작성 가능
                window.location.href = '/';
            },
            error: function(error) {
                // 실패 시 실행될 콜백 함수
                console.error('오류 발생:', error);
                alert('게시글 등록 중 오류가 발생하였습니다.');
            }
        });

    });
}

let checkSession = () => {
    let hUserId = $('#hiddenUserId').val();

    if (hUserId == null || hUserId === '')
        window.location.href = "/member/login";
}
