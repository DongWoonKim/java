
$(document).ready(() => {
    checkSession();

});

let checkSession = () => {
    let hUserId = $('#hiddenUserId').val();

    if (hUserId == null || hUserId === '')
        window.location.href = "/member/login";
}