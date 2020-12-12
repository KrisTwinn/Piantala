from django.contrib.auth.forms import UserCreationForm, UserChangeForm
from django.contrib.auth.models import User
from django import forms

class CustomUserCreationForm(UserCreationForm):
    #class Meta(UserCreationForm.Meta):
    #    fields = UserCreationForm.Meta.fields + ("email",)
    #    fields = UserCreationForm.Meta.fields + ("first_name",)
    #    fields = UserCreationForm.Meta.fields + ("last_name",)
    email = forms.EmailField()
    nome = forms.CharField(max_length=50)
    cognome = forms.CharField(max_length=50)
    class Meta:
        model = User
        fields = ('username','nome','cognome','email','password1','password2')
        help_texts = {
            'username': None,
        }

class EditProfileForm(UserChangeForm):
    template_name='/accounts/edit_profile'
    password = None
    class Meta:
        model = User
        fields = (
            'email',
            'first_name',
            'last_name',
            #'password',
        )