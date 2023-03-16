function sordArray(arr, order) {
    let sortingNumbers = (a, b) => a - b

    if(order === "asc") {
        return arr.sort(sortingNumbers)
    }

    return arr.sort(sortingNumbers).reverse()
}

console.log(sordArray([14, 7, 17, 6, 8], 'asc'))
console.log(sordArray([14, 7, 17, 6, 8], 'desc'))