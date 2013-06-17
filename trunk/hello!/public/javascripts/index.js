//Geolocalisation
var marker1 = L.marker([1,1]);
function testGeoloc() {
    if (!navigator.geolocation) {
    	alert("votre navigateur ne supporte pas la geolocalisation");
        return;
    }
    navigator.geolocation.watchPosition(
        // Succès
        function (position) {
            var lat = position.coords.latitude;
            var lng = position.coords.longitude;
            var redIcon = L.icon({
                iconUrl: 'public/images/icon_red.png',
                iconSize:     [64, 64], // taille de l'icone
                iconAnchor:   [22, 94],
            });
            map.removeLayer(marker1);
            marker1 =  L.marker([lat, lng], {icon: redIcon}).addTo(map);
        },
        // Erreur
        function (error) {
        },
        // Configuration
        {
            maximumAge: 60000,
            enableHighAccuracy: true,
            timeout: 2000
        }
    );
}

//Ajout de la map dans la page
var map = L.map('map', {
	center : [ 48.904, 2.2135 ],
	zoom : 17
});
L.tileLayer(
	'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
	{
		attribution : '',
		maxZoom : 19
	}
).addTo(map);
	
// Parsage du JSON pour un affichage dans la fenetre de detail
var pathImgUpload = "/public/images/upload/";
$.getJSON('/webservices/listeBatimentsJSON', function(data) {
	$.each(data.response.batiment, function(keyBatiment, batiment) {
		var marker = L.marker([batiment.latitude, batiment.longitude]).addTo(map);
		var titlePOI = batiment.nom;
		marker.bindPopup(
			$("<b>" + titlePOI + "</b>")
			.append("<br/><br/>")
			.append("<button id=\"detailsButton\" class=\"btn btn-small btn-primary\" type=\"button\">En savoir +</button>")
			.click(function() {
				$('#details').modal('show');
				$("#myModalLabel").text(titlePOI);
				$(".accordion-group").remove();
				$("#myCarousel").remove();
				var templateAccordion = '';
				var templateCarousel ='';
				var i = 0;
				if(typeof batiment.activite != 'undefined') {
					$.each(batiment.activite, function(keyActivite, activite) {
						var templateAccordionDescription = '';
							if(typeof activite.description != 'undefined') {
								// Affichage accordéon
								$.each(activite.description, function(keyDescription, description) {
									if(activite.libelle.match("^Images")){
										// Affichage carousel
										if(i == 0) {
											templateCarousel = $('<div id="myCarousel" class="carousel slide" style="width:300px;"><ol class="carousel-indicators"><li data-target="#myCarousel" data-slide-to="0" class="active"></li></ol><div class="carousel-inner"></div><a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a><a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a></div>');
											templateCarousel.find('.carousel-inner').append('<div class="item active"><img src="' + pathImgUpload + description.cle + '" alt=""><div class="carousel-caption"><p>' + description.valeur + '</p></div></div>');
										}
										else {
											templateCarousel.find('.carousel-indicators').append('<li data-target="#myCarousel" data-slide-to="' + i + '"></li>');
											templateCarousel.find('.carousel-inner').append('<div class="item"><img src="' + pathImgUpload + description.cle + '" alt=""><div class="carousel-caption"><p>' + description.valeur + '</p></div></div>');
										}
										i++;
									} else {
										templateAccordionDescription += description.cle + ' : ' + description.valeur + '<br />';
									}
								});
								if(! activite.libelle.match("^Images")){
									templateAccordion += '<div class=\"accordion-group\"><div class=\"accordion-heading\"><a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#myAccordion\" href=\"#'+activite.libelle+'\"> '+activite.libelle+' </a></div><div id=\"'+activite.libelle+'\" class=\"accordion-body collapse\"><div class=\"accordion-inner\">'+templateAccordionDescription+'</div></div></div>';
								}
							}
						});
				}
				$('#carousel-place').append(templateCarousel);
				$('#myAccordion').append(templateAccordion);
				$(".commentaires-facebook").empty();
				$(".commentaires-facebook").append('<fb:comments href="http://geoloc-upo.servebeer.com/webservices/batimentJSON/' + batiment.id + '" width="470" num_posts="10"></fb:comments>');
				FB.XFBML.parse();
		})[0]);
	});
});

/* Dimensions de la map selon la presence de la menu-bar */
$(document).ready(function() {
	$.ajaxSetup({
		cache : false
	});
	if ($(window).width() > 767) {
		$('#map').css('height', ($(window).height() - 40));
	}
	if ($(window).width() < 767) {
		//Suppression copyright sur la version mobile
		$('.leaflet-bottom.leaflet-right').remove();
	}
});

$(window).resize(function() {
	if ($(window).width() > 767) {
		$('#map').css('height', ($(window).height() - 40));
	}
	if ($(window).width() < 767) {
		//Suppression copyright sur la version mobile
		$('.leaflet-bottom.leaflet-right').remove();
	}
}).resize();