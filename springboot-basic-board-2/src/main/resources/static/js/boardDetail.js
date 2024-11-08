
$(document).ready(() => {
    checkSession();
    loadBoardDetail();
});

let editArticle = () => {
    let resourceId = $('#hiddenId').val();
    window.location.href = "/update/" + resourceId;
}

let deleteArticle = () => {

    let resourceId = $('#hiddenId').val();
    let filePath = $('#hiddenFilePath').val();

    $.ajax({
        type: 'DELETE',
        url: '/api/board/' + resourceId, // 실제 서버 API URL 및 삭제할 리소스 ID
        data: JSON.stringify({ filePath: filePath }), // filePath를 JSON으로 서버에 전송
        contentType: 'application/json', // JSON 형식으로 전송
        success: (response) => {
            alert('리소스가 성공적으로 삭제되었습니다.');
            window.location.href = '/'; // 성공 후 목록 페이지로 이동
        },
        error: (error) => {
            alert('리소스 삭제 중 오류가 발생했습니다.');
            console.error('Error:', error);
        }
    });
}

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
                $('#deleteBtn').prop('disabled', true);
            }

            // 파일 목록이 있는 경우, 파일 다운로드 링크 추가
            if (response.filePath && response.filePath.length > 0) {
                let filePath = response.filePath;
                $('#hiddenFilePath').val(filePath)
                let fileName = filePath.substring(filePath.lastIndexOf('\\') + 1); // 파일명 추출
                let fileElement = `
                            <li>
                                <a href="/api/board/file/download/${fileName}">${fileName}</a> <!-- 다운로드 링크 -->
                            </li>`;
                $('#fileList').append(fileElement);
            } else {
                $('#fileList').append('<li>첨부된 파일이 없습니다.</li>');
            }

        },
        error: function (error) {
            console.error('오류 발생:', error);
            alert('상세 데이터를 불러오는데 오류가 발생했습니다.');
        }
    });
}