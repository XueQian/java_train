/**
 * Created by qxue on 7/14/15.
 */
function deleteUserById(id){
    $.ajax({
        url:'/web/users/'+id,
        type:'DELETE',
        dataType:'text',
        success:function(){
            window.location.reload();
        }
    })
}