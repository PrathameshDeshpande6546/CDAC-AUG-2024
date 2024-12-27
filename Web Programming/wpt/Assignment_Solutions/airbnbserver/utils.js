

function createErrorResult(error) {  // if any error occurs in application we need to send error info to user with status code as a errror.
  return { status: "error", error };
}
function createSuccessResult(data) {  //create success result when request (get post delete put) is sucessefully we need to send data along with status as a success.
  return { status: "success", data };
}
function createResult(error, data) {  //creating the final result depending on status.
  return error ? createErrorResult(error) : createSuccessResult(data);
}
module.exports = {   //to make available all three functions in other js files.
  createResult,
  createSuccessResult,
  createErrorResult,
};

