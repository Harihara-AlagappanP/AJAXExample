/*Getting all the districts*/
let xhr = new XMLHttpRequest();

xhr.open("GET", "get-districts");
xhr.send();
xhr.onload = function(){
	let obj = JSON.parse(xhr.response);
	districts = obj["@items"];
	filterDistricts();
}
/*----*/

const SEARCHBAR = document.getElementById("search-box");
const DISPLAYREGION = document.getElementById("display-districts");


let autoComplete = function(event){
	SEARCHBAR.value = event.currentTarget.innerText;
}

let filterByName = function(name){
	return name.toLowerCase().includes(SEARCHBAR.value.toLowerCase());
}

let filterDistricts = function(){
	while (DISPLAYREGION.hasChildNodes()) {
        DISPLAYREGION.removeChild(DISPLAYREGION.firstChild); // Removing all the before searched elements
    }

    let filteredDistricts = districts.filter(filterByName);

    for(index = 0; index < filteredDistricts.length; index++){
        const NAMEPARAGRAPHELEMENT = document.createElement('p');
        NAMEPARAGRAPHELEMENT.setAttribute("class", "filtered-districts");
		NAMEPARAGRAPHELEMENT.addEventListener("click", autoComplete);

       	//Highlighting the searched part
        let indexOfSearchedElement = filteredDistricts[index].toLowerCase().indexOf(SEARCHBAR.value.toLowerCase()); 
        let lengthOfSearchedElement = SEARCHBAR.value.length;

        const NAMEFRAGMENT = document.createDocumentFragment();
        const BEFOREPART = document.createElement('span');
        const SEARCHEDPART = document.createElement('span');
        const AFTERPART = document.createElement('span');

        SEARCHEDPART.setAttribute("class", "searched-part");

        BEFOREPART.textContent = filteredDistricts[index].substring(0, indexOfSearchedElement);
        SEARCHEDPART.textContent = filteredDistricts[index].substring(indexOfSearchedElement, indexOfSearchedElement + lengthOfSearchedElement)
        AFTERPART.textContent = filteredDistricts[index].substring(indexOfSearchedElement + lengthOfSearchedElement);

        NAMEFRAGMENT.appendChild(BEFOREPART);
        NAMEFRAGMENT.appendChild(SEARCHEDPART);
        NAMEFRAGMENT.appendChild(AFTERPART);

        NAMEPARAGRAPHELEMENT.appendChild(NAMEFRAGMENT);
        
        DISPLAYREGION.appendChild(NAMEPARAGRAPHELEMENT);
    }
}

SEARCHBAR.addEventListener("input", filterDistricts);

