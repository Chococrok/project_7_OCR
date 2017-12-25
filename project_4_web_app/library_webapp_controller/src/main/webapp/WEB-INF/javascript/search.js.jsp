<script>
	var searchForm = document.getElementById('searchForm');
	var input = document.getElementById('inputSearch');
	var searchTypeButtons = document.getElementsByClassName('searchTypeButton');
	var btnGroupAddon = document.getElementById('btnGroupAddon');
	var listOptions = {
			<c:forEach items = "${ requestScope.tags }" var = "tag">
				${ tag.value },
			</c:forEach>
	}

	searchForm.addEventListener('submit', function(event) {
		if (this.inputSearch.value === '') {
			event.preventDefault();
		}
	});

	for (var i = 0; i < searchTypeButtons.length; i++) {
		searchTypeButtons[i].addEventListener('click', function(event) {
			searchForm.action = document.location.origin + '/library/search/'
					+ event.target.value;
			btnGroupAddon.lastChild.data = event.target.lastChild.data;
		});		
	}
</script>