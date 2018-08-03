<script>
	var reminderInput = document.getElementById('reminderInput');
	var reminderForm = document.getElementById('reminderForm');

	reminderInput.addEventListener('change', function(event) {
		if (event.target.checked) {
			reminderInput.value = true;
		} else {
			reminderInput.value = false;
			reminderInput.checked = true;
		}
		
		reminderForm.submit()
	
	});
</script>