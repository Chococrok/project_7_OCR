<script>
	var buttonsNav = document.getElementsByClassName('btn-nav');
	
	
	function load() {
		for(var i = 0; i < buttonsNav.length; i++) {
			buttonsNav[i].addEventListener('click', function(event) {
				location.href = document.location.origin + '/library/' + event.target.value;
			});
		}
	}
</script>