var filter = function (arr, fn) 
{
  const returnedArr = [];
  for (let i = 0; i < arr.length; i++) 
  {
    if (fn(arr[i], i)) 
    {
      returnedArr.push(arr[i]);
    }
  }
  return returnedArr;
};