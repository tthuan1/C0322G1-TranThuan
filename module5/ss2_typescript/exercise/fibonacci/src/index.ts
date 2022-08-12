// happy coding 👻
function fibonnacci(n: number): number {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return fibonnacci(n - 2) + fibonnacci(n - 1);
    }
}

function display() {
    // @ts-ignore
    let m = document.getElementById("num").value;
    let fibonnacciList = 0;
    for (let i = 0; i < m; i++) {
        console.log("Số thứ "+(i+1)+" là: "+fibonnacci(i));
        fibonnacciList += fibonnacci(i);
    }
    // @ts-ignore
    document.getElementById("ketQua").innerHTML="Tổng các số fibonnacci là: "+ fibonnacciList;
}



