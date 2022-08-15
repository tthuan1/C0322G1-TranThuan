// happy coding 👻
function fibonacci(n: number): number {
  if (n == 0 || n == 1) {
    return n;
  } else {
    return fibonacci(n - 2) + fibonacci(n - 1);
  }
}

function displayTotal() {
  // @ts-ignore
  let m = document.getElementById("num").value;
  let totalFibonacci = 0;
  for (let i = 0; i < m; i++) {
    console.log("Số thứ " + (i + 1) + " là: " + fibonacci(i));
    totalFibonacci += fibonacci(i);
  }
  // @ts-ignore
  document.getElementById("ketQua").innerHTML = "Tổng các số fibonnacci là: " + totalFibonacci;
}



