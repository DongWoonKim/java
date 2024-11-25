$(document).ready(() => {
    $('#catalogCreate').click(() => {
        let isbn = $('#isbn').val();
        let title = $('#title').val();
        let author = $('#author').val();
        let price = $('#price').val();

        let formData = {
            isbn: isbn,
            title: title,
            author: author,
            price: price
        };

        $.ajax({
            type: 'POST',
            url: '/admin/api/catalog', // 서버의 엔드포인트 URL
            data: JSON.stringify(formData), // 데이터를 JSON 형식으로 변환
            contentType: 'application/json; charset=utf-8', // 전송 데이터의 타입
            dataType: 'json', // 서버에서 받을 데이터의 타입
            success: (response) => {
            },
            error: (error) => {
                // 실패 시 실행될 콜백 함수
                console.error('오류 발생:', error);
            }
        });

    });
});