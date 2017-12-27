<script>
	var searchForm = document.getElementById('searchForm');
	var input = document.getElementById('inputSearch');
	var searchTypeButtons = document.getElementsByClassName('searchTypeButton');
	var btnGroupAddon = document.getElementById('btnGroupAddon');
	var dataList = document.getElementById('listSearch');
	var listOptions = [
			<c:forEach items = "${ requestScope.tags }" var = "tag">
				"${ tag.value }",
			</c:forEach>
	];
	
	function load() {
		
		searchForm.addEventListener('submit', function(event) {
			if (this.inputSearch.value === '') {
				event.preventDefault();
			}
		});
		
		for(var i = 0; i < searchTypeButtons.length; i++) {
			searchTypeButtons[i].addEventListener('click', function(event) {
				searchForm.action = document.location.origin + '/library/search/'
						+ event.target.value;
				btnGroupAddon.lastChild.data = event.target.lastChild.data;
				enableAutoComplete ();
			});		
		}
		
		enableAutoComplete ();
	}
	
	function createListOptions() {
		for(var i = 0; i < listOptions.length; i++) {
			const newOption = document.createElement('option');
			newOption.value = listOptions[i];
			listSearch.appendChild(newOption);
		}
	}
	
	function enableAutoComplete () {
		if (btnGroupAddon.lastChild.data != 'Tag') {
			while (listSearch.firstChild) {
				listSearch.removeChild(listSearch.firstChild);
			}
		} else {
			createListOptions();
		}
	}
</script>