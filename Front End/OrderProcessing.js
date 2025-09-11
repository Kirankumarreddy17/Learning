const items = {
    burger: 120,
    pizza: 250,
    pasta: 180,
    coffee: 80
};
let order = ["burger", "pizza", "pasta", "coffee"];
let total = 0;
for(let i=0;i<order.length;i++){
    let item = order[i];
    
    if(items[item] ){
        total = total + items[item];
    }
    else{
        console.log("Item is not in the list");
    }
}
let discount = 0;
console.log("Total price : " + total);
if(order.length > 3){
    discount = total * 0.10;
    console.log("Discount applied: " + discount);
}
const bill =  (total - discount);
console.log("Final price is : " + bill);